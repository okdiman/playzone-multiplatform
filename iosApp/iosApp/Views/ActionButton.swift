//
//  ActionButton.swift
//  iosApp
//
//  Created by Дмитрий Окунев on 10.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ActionButton: View {
    
    private let title: String
    private let enabled: Bool
    private let height: CGFloat
    private let horizontalMargin: CGFloat
    private let action: () -> Void
    
    init(title: String, enabled: Bool = true, height: CGFloat = 56, horizontalMargin: CGFloat  = 16, action: @escaping () -> Void) {
        self.title = title
        self.enabled = enabled
        self.height = height
        self.horizontalMargin = horizontalMargin
        self.action = action
    }
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.textTintColorPrimary)
                .opacity(enabled ? 1.0 : 0.5)
            
            Text(title)
                .foregroundColor(.textAction)
        }
        .frame(maxWidth: .infinity, maxHeight: height)
        .padding(EdgeInsets(top: 0, leading: horizontalMargin, bottom: 0, trailing: horizontalMargin))
        .onTapGesture {
            action()
        }
    }
}

struct ActionButton_Previews: PreviewProvider {
    static var previews: some View {
        ActionButton(title: "Action") { 
            
        }
    }
}
